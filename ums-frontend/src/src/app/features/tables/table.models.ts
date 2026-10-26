export type FieldType = 'text' | 'textarea' | 'number' | 'decimal' | 'date' | 'time';
export type FieldSection = 'main' | 'status' | 'extra' | 'audit';

export interface FieldDef {
  name: string;
  label: string;
  type: FieldType;
  section: FieldSection;
  required?: boolean;
  max?: number;
  min?: number;
  step?: string;
  /** passwords / secret keys: masked in the list, password input in the form */
  secret?: boolean;
}

export interface TableDef {
  /** url segment, e.g. "candidate-quali" */
  key: string;
  label: string;
  description: string;
  singular: string;
  /** REST path under API_URL, e.g. "/candidate-quali" (empty when the table has its own page) */
  endpoint: string;
  /** set for tables that already have their own screens (employees, candidates, experience) */
  link: string;
  columns: string[];
  fields: FieldDef[];
  idField: string;
}

export interface TableGroup {
  label: string;
  tables: TableDef[];
}

/** One database row. */
export type Row = Record<string, any>;
