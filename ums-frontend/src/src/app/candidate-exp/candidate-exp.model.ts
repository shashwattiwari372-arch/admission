export interface CandidateExp {
  id?: number;
  appId: number;
  employerName: string;
  orgType?: string | null;
  orgWebsite?: string | null;
  orgMobile?: string | null;
  orgEmail?: string | null;
  fromDt: string;
  toDt?: string | null;
  noOfYears?: number | null;
  noOfMonths?: number | null;
  noOfDays?: number | null;
  designation: string;
  payLevel?: string | null;
  jobType?: string | null;
  lastPay?: string | null;
  basicPay?: number | null;
  otherAllowance?: number | null;
  totalEmoluments?: number | null;
  natureWork?: string | null;
  responsibilities?: string | null;
  reasonLeave?: string | null;
  remark?: string | null;
  updateBy?: string | null;
  updateDt?: string | null;
  vStatus?: string | null;
  pStatus?: string | null;
}
