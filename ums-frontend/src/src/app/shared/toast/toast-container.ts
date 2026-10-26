import { Component, inject } from '@angular/core';
import { ToastService } from '../../core/services/toast.service';

@Component({
  selector: 'app-toasts',
  template: `
    <div class="stack" aria-live="polite">
      @for (t of toasts.toasts(); track t.id) {
        <div class="toast" [class]="t.kind" role="status">
          <span class="msg">{{ t.message }}</span>
          <button type="button" class="x" (click)="toasts.dismiss(t.id)" aria-label="Dismiss">×</button>
        </div>
      }
    </div>
  `,
  styles: `
    .stack { position: fixed; top: 16px; right: 16px; z-index: 200; display: flex; flex-direction: column; gap: 10px; width: min(380px, calc(100vw - 32px)); pointer-events: none; }
    .toast { pointer-events: auto; display: flex; align-items: center; gap: 12px; padding: 12px 14px; border-radius: 10px; background: #0e1a2b; color: #fff; box-shadow: 0 12px 32px rgba(14,26,43,.3); border-left: 4px solid #6c8cff; animation: in .22s ease; font-size: 14px; }
    .toast.success { border-left-color: #34c26b; }
    .toast.error { border-left-color: #ff6b6b; }
    .msg { flex: 1; }
    .x { background: none; border: 0; color: #9fb0c8; font-size: 20px; line-height: 1; padding: 0 2px; }
    .x:hover { color: #fff; }
    @keyframes in { from { opacity: 0; transform: translateY(-8px); } }
    @media (max-width: 720px) { .stack { top: auto; bottom: 16px; } }
  `,
})
export class ToastContainer {
  toasts = inject(ToastService);
}
