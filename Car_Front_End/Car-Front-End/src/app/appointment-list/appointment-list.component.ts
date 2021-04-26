import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {
  appointments: Appointment[];
  msg:string;
  errorMsg:string;

  constructor(private appointmentService: AppointmentService, private router: Router) { }

  ngOnInit(): void {
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

  

  appointmentDetails(appointmentId: number){
    this.router.navigate(['appointment-details', appointmentId]);
  }
  deleteAppointment(appointmentId: number){
    if(confirm("Confirm Deletion of Appointment Id:"+appointmentId)){
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
  }
}
}                                                         