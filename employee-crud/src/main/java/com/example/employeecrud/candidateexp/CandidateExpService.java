package com.example.employeecrud.candidateexp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateExpService {

    private final CandidateExpRepository repository;

    public CandidateExpService(CandidateExpRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CandidateExp> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CandidateExp> findByAppId(Integer appId) {
        return repository.findByAppIdOrderByFromDtDesc(appId);
    }

    @Transactional(readOnly = true)
    public CandidateExp findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Experience not found with id " + id));
    }

    public CandidateExp create(CandidateExp exp) {
        exp.setId(null);
        prepare(exp);
        return repository.save(exp);
    }

    public CandidateExp update(Integer id, CandidateExp incoming) {
        CandidateExp existing = findById(id);
        // keep id and verification / payment audit columns untouched
        BeanUtils.copyProperties(incoming, existing,
                "id", "vStatus", "vBy", "vStamp", "pStatus", "pBy", "pStamp");
        prepare(existing);
        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.delete(findById(id));
    }

    /** Fills duration, total emoluments and audit columns. */
    private void prepare(CandidateExp exp) {
        if (exp.getFromDt() != null) {
            LocalDate end = exp.getToDt() != null ? exp.getToDt() : LocalDate.now();
            Period p = Period.between(exp.getFromDt(), end);
            exp.setNoOfYears(p.getYears());
            exp.setNoOfMonths(p.getMonths());
            exp.setNoOfDays(p.getDays());
        }
        if (exp.getBasicPay() != null || exp.getOtherAllowance() != null) {
            BigDecimal basic = exp.getBasicPay() != null ? exp.getBasicPay() : BigDecimal.ZERO;
            BigDecimal other = exp.getOtherAllowance() != null ? exp.getOtherAllowance() : BigDecimal.ZERO;
            exp.setTotalEmoluments(basic.add(other));
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        exp.setUpdateBy(auth != null ? auth.getName() : "system");
        exp.setUpdateDt(LocalDate.now());
        exp.setUpdateTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
