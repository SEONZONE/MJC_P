<?php
	$con = mysqli_connect("localhost","seonzone","toto2409!","seonzone");
	mysqli_query($con,'SET NAMES utf8');

	$userID = $_POST["userID"];
	$userPassword = $_POST["userPassword"];
	$userName = $_POST["userName"];
	$userAddress = $_POST["userAddress"];

	$statement = mysqli_prepare($con, "INSERT INTO USER VALUES(?,?,?,?)");
	mysqli_stmt_bind_param($statement, "ssss", $userID, $userPassword, $userName,$userAddress);
	mysqli_stmt_execute($statement);

	$response = array();
	$response["success"] = true;

	
	echo json_encode($response);

?>

