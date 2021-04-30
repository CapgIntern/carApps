import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-appointment-all',
  templateUrl: './appointment-all.component.html',
  styleUrls: ['./appointment-all.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class AppointmentAllComponent implements OnInit {
  appointments: Appointment[];
  msg:string;
  errorMsg:string;
  userId: string;

  constructor(private appointmentService: AppointmentService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) { 
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.userId=localStorage.getItem("userId");
    this.getAppointments();
  }

  private getAppointments(){
    this.appointmentService.getAppointmentsList().subscribe(data => {
      this.appointments = data;
    });
  }

  updateAppointment(appointmentId: number){
    this.router.navigate(['update-appointment', appointmentId]);
  }

  addOrder(appointmentId: number){
    this.router.navigate(['add-orders', appointmentId]);
  }
  

  appointmentDetails(appointmentId: number){
    this.router.navigate(['appointment-details', appointmentId]);
  }
  deleteAppointment(appointmentId: number){
   
      this.appointmentService.deleteAppointment(appointmentId)
      .subscribe(data=>{
       
        this.errorMsg=undefined;
        this.appointmentService.getAppointmentsList().subscribe(data=>this.appointments=data);
        console.log(this.appointments);
      },
        error=>{
          this.errorMsg=error.error;
          this.msg=undefined;
        });
        this.getAppointments();
}
open(content) {
  this.modalService.open(content, { centered: true });
}

}
