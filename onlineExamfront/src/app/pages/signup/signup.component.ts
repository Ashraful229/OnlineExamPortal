import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService,private snack:MatSnackBar) { }

  public user={
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:'',

  }

  ngOnInit(): void {}
  formSubmit()
  {
  console.log(this.user);
  if(this.user.username==''||this.user.username==null)
  {
    //alert("User is required !!");
    this.snack.open("User is required !!","",{
      duration:2000,
      verticalPosition:'top',
      horizontalPosition:'right',
    })
    return;
  }
  //add user
  this.userService.addUser(this.user).subscribe(
    (data)=>
    {
    console.log(data);
    this.snack.open("User register successfuly !!","",{
      duration:2000,
      verticalPosition:'top',
      horizontalPosition:'right',
    })
    },
    (error)=>
    {
     console.log(error);
     //alert('something went wrong');
     this.snack.open("something went wrong !!","",{
      duration:2000,
      verticalPosition:'top',
      horizontalPosition:'right',
    })
    
    }

    
  )
  }

}
