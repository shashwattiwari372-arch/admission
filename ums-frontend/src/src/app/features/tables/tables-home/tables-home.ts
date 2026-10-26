import { Component, computed, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { TABLE_GROUPS } from '../tables.config';
import { TableDef } from '../table.models';

@Component({
  selector: 'app-tables-home',
  imports: [RouterLink],
  templateUrl: './tables-home.html',
  styles: `
    .grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 14px; }
    .tile { display: flex; flex-direction: column; gap: 6px; padding: 16px 18px; color: inherit; transition: border-color .15s, transform .15s; }
    .tile:hover { border-color: var(--accent); transform: translateY(-1px); color: inherit; }
    .tile h3 { font-size: 15px; }
    .tile p { color: var(--muted); font-size: 13px; flex: 1; }
    .tile code { font-size: 12px; color: var(--accent-600); }
    .tile .row { display: flex; justify-content: space-between; align-items: center; gap: 8px; }
    .group { margin-top: 26px; }
    .group > h2 { font-size: 15px; margin-bottom: 12px; color: var(--muted); text-transform: uppercase; letter-spacing: .06em; font-size: 12.5px; }
    .search-row { margin-bottom: 4px; max-width: 420px; }
  `,
})
export class TablesHome {
  query = signal('');

  groups = computed(() => {
    const q = this.query().trim().toLowerCase();
    return TABLE_GROUPS.map((g) => ({
      label: g.label,
      tables: g.tables.filter(
        (t) => !q || [t.label, t.description, t.key].some((v) => v.toLowerCase().includes(q))
      ),
    })).filter((g) => g.tables.length > 0);
  });

  total = TABLE_GROUPS.reduce((n, g) => n + g.tables.length, 0);

  onSearch(ev: Event): void { this.query.set((ev.target as HTMLInputElement).value); }

  path(t: TableDef): string[] { return t.link ? [t.link] : ['/tables', t.key]; }
}
