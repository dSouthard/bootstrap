<?php
// register.php
// Simple registration page which accepts user name, joining date, and age grouping as a choice from 0 - 4. Duplicate user names are allowed.
// Set up database connection
 require_once 'dbconfig.php';

 if($_POST) {
  $user_name = $_POST['user_name'];
  $date =$_POST['user_name'];
  $ageGroup = $_POST['age_group']

  try {
   // Insert the new user into the table
   $stmt = $db_con->prepare("INSERT INTO tbl_users(user_name,user_email,user_password,joining_date) VALUES(:uname, :email, :pass, :jdate)");
   $stmt->bindParam(":uname",$user_name);
   $stmt->bindParam(":email",$user_email);
   $stmt->bindParam(":pass",$user_password);
   $stmt->bindParam(":jdate",$joining_date);

    if($stmt->execute()) {
     echo "New user inserted";
    }
    else {
     echo "Query could not execute!";
    }
  }
  catch(PDOException $e){
    // Error in inserting new user
    echo $e->getMessage();
  }
 }
?>
