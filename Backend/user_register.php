<?php

$email = $_POST['email'];
$password = $_POST['password'];
$register = $_POST['register'];



$servername = "127.0.0.1";
$username = "root";
$db_password = "";
$dbname = "online_cart";


$conn = new mysqli($servername, $username, $db_password, $dbname);


if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

 switch ($register) {
 	case 0:
 		$sql = "SELECT id from users where email='$email'password='$password'";
		$result = $conn->query($sql);
 		break;
 	case 1:
 		$sql = "INSERT INTO `online_cart`.`users`
			(`email`,
			`password`)
			VALUES
			('$email',
			'$password')";
 		break;
 	default:
 		# code...
 		break;
 }

if ($register == 1){
	if ($conn->query($sql) === TRUE) {
		$last_id = $conn->insert_id;
	    $result = array ('isOK'=>1,'user_id'=>$last_id);
		echo json_encode($result);
	} else {
		$error = $conn->error;
		$result = array ('isOK'=>0,'error'=>$error); 
		echo json_encode($result);
	}
}else{
	if ($result->num_rows > 0) {
		$row = $result->fetch_assoc();
		var_dump($result);
		var_dump($row);
		$user_id = $row['id'];
		$result = array ('isOK'=>1,'user_id'=>$user_id);
		echo json_encode($result);
	}else{
		$result = array ('isOK'=>0,'error'=>'User not found');
		echo json_encode($result);
	}
}

$conn->close();

?>