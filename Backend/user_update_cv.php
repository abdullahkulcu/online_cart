<?php
$last_name = $_POST['last_name'];
$first_name = $_POST['first_name'];
$general_title = $_POST['general_title'];
$user_info = $_POST['user_info'];
//$prof_image`=$_POST['prof_image`'];

$servername = "127.0.0.1";
$username = "root";
$password = "";
$dbname = "online_cart";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$date = new DateTime();
$time = $date->getTimestamp();

$sql = "INSERT INTO `online_cart`.`users`
(`email`,
`password`,
`first_name`,
`last_name`,
`general_title`,
`user_information`,
`profile_image`)
VALUES
('"$email"',
'"$password"',
'"$first_name"',
'"$last_name"',
'"$general_title"',
'"$user_info"',
'test_image_link')";

if ($conn->query($sql) === TRUE) {
	$last_id = $conn->insert_id;
    $result = array ('isOK'=>1,'user_id'=>$last_id);
	echo json_decode $result
} else {
	$error = $conn->error;
	$result = array ('isOK'=>0,'error'=>$error); 
	echo json_decode $result
}

$conn->close();

?>