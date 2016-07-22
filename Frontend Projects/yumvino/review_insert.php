<?php
ob_start();
session_start();
?>
<?php
$winery = $_POST['winery'];
$review = $_POST['review'];
$comments = $_POST['comments'];

$con = mysqli_connect("mysql11.000webhost.com","a9308444_bhaumik","5248ebdh","a9308444_first");
$sql = "INSERT INTO review (winery, title, comments)
		VALUES('$winery','$review','$comments')";
$result = mysqli_query($con, $sql);
?>
<?php
header("Location: review.html");
mysqli_close($con);
ob_flush();
?>