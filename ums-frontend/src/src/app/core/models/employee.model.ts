
export interface Employee {
  id?: number;
  fullName: string;
  email: string;
  password?: string;
  age: number;
  gender: string;
  department: string;
  skills: string[];
  employmentType: string;
  active: boolean;
  joiningDate: string;
  address: string;
  profileImage?: string;
  resume?: string;
}
