import { Component, HostListener, inject, signal } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { NavigationEnd, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { filter } from 'rxjs';
import { AuthService } from '../../core/services/auth.service';
import { ToastService } from '../../core/services/toast.service';

interface NavItem { label: string; path: string; icon: 'grid' | 'users' | 'id' | 'briefcase'; }
interface Crumb { label: string; url: string; }

@Component({
  selector: 'app-shell',
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './shell.html',
  styleUrl: './shell.css',
})
export class Shell {
  auth = inject(AuthService);
  private router = inject(Router);
  private toast = inject(ToastService);

  menuOpen = signal(false);
  crumbs = signal<Crumb[]>(this.buildCrumbs());

  nav: NavItem[] = [
    { label: 'Dashboard', path: '/dashboard', icon: 'grid' },
    { label: 'Employees', path: '/employees', icon: 'users' },
    { label: 'Candidates', path: '/candidates', icon: 'id' },
    { label: 'Experience', path: '/experience', icon: 'briefcase' },
  ];

  constructor() {
    this.router.events
      .pipe(filter((e) => e instanceof NavigationEnd), takeUntilDestroyed())
      .subscribe(() => {
        this.menuOpen.set(false); // close the mobile drawer after every navigation
        this.crumbs.set(this.buildCrumbs());
      });
  }

  @HostListener('document:keydown.escape')
  closeMenu(): void { this.menuOpen.set(false); }

  toggleMenu(): void { this.menuOpen.update((v) => !v); }

  logout(): void {
    this.auth.logout();
    this.toast.info('You have been signed out.');
    this.router.navigate(['/login']);
  }

  /** Builds "Employees / New employee" from the `crumb` data on the active route chain. */
  private buildCrumbs(): Crumb[] {
    const out: Crumb[] = [];
    let route: any = this.router.routerState.snapshot.root;
    let url = '';
    while (route) {
      const seg = route.url.map((s: { path: string }) => s.path).join('/');
      if (seg) url += '/' + seg;
      const label = route.data?.['crumb'] as string | undefined;
      if (label && out[out.length - 1]?.label !== label) out.push({ label, url });
      route = route.firstChild;
    }
    return out;
  }
}
