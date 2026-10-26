export interface CandidateProfile {
  id?: number;

  title?: string | null;
  fullName: string;
  email: string;
  mobileNo?: string | null;

  fatherHusbandName?: string | null;
  motherName?: string | null;
  fatherMobile?: string | null;
  motherMobile?: string | null;
  fatherOccupation?: string | null;
  motherOccupation?: string | null;
  siblings?: number | null;
  annualIncome?: string | null;

  orgName?: string | null;
  designation?: string | null;
  city?: string | null;
  distt?: string | null;
  state?: string | null;
  orgPhone?: string | null;
  orgEmail?: string | null;
  orgWebsite?: string | null;

  physicallyChallenged?: string | null;

  aadhaarNo?: string | null;
  apaarId?: string | null;
  panNo?: string | null;
  voterId?: string | null;
  passportNo?: string | null;
  drivingLicenseNo?: string | null;

  gender?: string | null;
  bloodGroup?: string | null;
  category?: string | null;

  localAddress?: string | null;
  permanentAddress?: string | null;

  dob?: string | null;
  maritalStatus?: string | null;

  remark?: string | null;

  updateBy?: string | null;
  updateDt?: string | null;
  updateTime?: string | null;

  alternativeEmail?: string | null;
  nationality?: string | null;
  religion?: string | null;

  f1?: string | null;
  f2?: string | null;
  f3?: string | null;
  f4?: string | null;
  f5?: string | null;

  vStatus?: string | null;
  vBy?: string | null;
  vStamp?: string | null;

  pStatus?: string | null;
  pBy?: string | null;
  pStamp?: string | null;
}