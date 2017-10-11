<?php
// dbconfig.php
// Simple php script to connect webpage to MySQL database
// Database connection information
 $db_host = "localhost";
 $db_name = "bootstrapSchema";
 $db_user = "bootstrap";
 $db_pass = "bootstrap";  // NOTE: This will need to be hardened such that it's not stored in clear text

 try {
   // Set up new connection to database
  $db_con = new PDO("mysql:host={$db_host};dbname={$db_name}",$db_user,$db_pass);
  $db_con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
 }
 catch(PDOException $e) {
   // Error connecting
   echo $e->getMessage();
 }
?>
