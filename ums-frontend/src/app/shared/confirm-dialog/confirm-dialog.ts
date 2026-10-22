import { Component, HostListener, input, output } from '@angular/core';

@Component({
  selector: 'app-confirm-dialog',
  template: `
    <div class="backdrop" (click)="cancelled.emit()">
      <div class="dialog" role="alertdialog" aria-modal="true" aria-labelledby="dlg-title" (click)="$event.stopPropagation()">
        <h3 id="dlg-title">{{ heading() }}</h3>
        <p>{{ message() }}</p>
        <div class="actions">
          <button type="button" class="btn btn-ghost" (click)="cancelled.emit()" [disabled]="busy()">Keep it</button>
          <button type="button" class="btn btn-danger" (click)="confirmed.emit()" [disabled]="busy()">
            @if (busy()) { <span class="spinner"></span> }
            {{ busy() ? 'Deleting…' : confirmLabel() }}
          </button>
        </div>
      </div>
    </div>
  `,
  styles: `
    .backdrop { position: fixed; inset: 0; z-index: 150; display: grid; place-items: center; padding: 16px; background: rgba(14,26,43,.5); animation: fade .15s ease; }
    .dialog { width: min(430px, 100%); background: #fff; border-radius: 14px; padding: 24px; box-shadow: var(--shadow-pop); animation: pop .18s ease; }
    h3 { font-size: 18px; margin-bottom: 8px; }
    p { color: var(--muted); margin-bottom: 22px; }
    .actions { display: flex; justify-content: flex-end; gap: 10px; }
    @keyframes fade { from { opacity: 0; } }
    @keyframes pop { from { opacity: 0; transform: translateY(8px) scale(.98); } }
  `,
})
export class ConfirmDialog {
  heading = input.required<string>();
  message = input<string>('');
  confirmLabel = input<string>('Delete');
  busy = input<boolean>(false);
  confirmed = output<void>();
  cancelled = output<void>();

  @HostListener('document:keydown.escape')
  onEscape(): void {
    if (!this.busy()) this.cancelled.emit();
  }
}
