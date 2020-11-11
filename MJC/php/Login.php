<? php
	$con = mysqli_connect("localhost","seonzone","toto2409!","seonzone");
	mysqli_query($con,'SET NAMES utf8');

	$userID = $_POST["userID"];
	$userPassword = $_POST["userPassword"];

	$statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPassword =  ? ");
	mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	myslqi_stmt_bind_result($statement, $userID, $userPassword, $userName, $userAddress);

	$response = array();
	$response["success"] = false;

	while(mysqli_stmt_fetch($statement)) {
		$response["success"] = true;
		$response["userID"] = userID;
		$response["userPassword"] = userPassword;
		$response["userName"] = userName;
		$response["userAddress"] = userAddress;
	}
	
	echo json_encode($response);

	?>

