export type ISidebarSize = 'lg' | 'sm';

export interface IMenuItem {
  label: string;
  type: string;
  to?: string;
  icon?: string;
  children?: IMenuItem[];
  extra?: {
    badge?: {
      label: string;
      class: string;
    }
  };
}
