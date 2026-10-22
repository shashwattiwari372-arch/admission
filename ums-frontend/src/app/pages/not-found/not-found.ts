import { Component, inject } from '@angular/core';
import { Location } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-not-found',
  imports: [RouterLink],
  template: `
    <div class="wrap">
      <p class="code">404</p>
      <h1>We can’t find that page</h1>
      <p class="msg">The link may be broken or the page may have moved.</p>
      <div class="row">
        <button type="button" class="btn btn-ghost" (click)="back()">Go back</button>
        <a class="btn btn-primary" routerLink="/dashboard">Go to dashboard</a>
      </div>
    </div>
  `,
  styles: `
    .wrap { min-height: 100vh; display: grid; place-content: center; justify-items: center; gap: 10px; padding: 24px; text-align: center; }
    .code { font-size: 84px; font-weight: 800; letter-spacing: -0.05em; color: var(--accent); line-height: 1; }
    h1 { font-size: 26px; }
    .msg { color: var(--muted); }
    .row { display: flex; gap: 10px; margin-top: 14px; }
  `,
})
export class NotFound {
  private location = inject(Location);
  back(): void { this.location.back(); }
}
