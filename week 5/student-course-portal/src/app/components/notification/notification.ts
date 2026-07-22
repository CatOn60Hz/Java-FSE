import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [CommonModule],
  templateUrl: './notification.html',
  styleUrl: './notification.css',
  // Component-level providers create a new service instance for that component and its children.
  // Useful when you need isolated state per component instance.
  providers: [NotificationService] 
})
export class Notification {
  constructor(public notificationService: NotificationService) {}

  triggerNotification() {
    this.notificationService.addMessage('New notification received at ' + new Date().toLocaleTimeString());
  }
}
