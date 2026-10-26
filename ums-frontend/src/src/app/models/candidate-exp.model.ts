export interface CandidateExp {
  id?: number;
  appId: number;
  employerName: string;
  orgType?: string | null;
  orgWebsite?: string | null;
  orgMobile?: string | null;
  orgEmail?: string | null;
  designation: string;
  jobType?: string | null;
  fromDt: string;            // yyyy-MM-dd
  toDt?: string | null;      // empty = current job
  noOfYears?: number | null;
  noOfMonths?: number | null;
  noOfDays?: number | null;
  payLevel?: string | null;
  lastPay?: string | null;
  basicPay?: number | null;
  otherAllowance?: number | null;
  totalEmoluments?: number | null;
  natureWork?: string | null;
  responsibilities?: string | null;
  reasonLeave?: string | null;
  remark?: string | null;
}
