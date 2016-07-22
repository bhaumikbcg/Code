<?php
ob_start();
session_start();
?>
<?php
$comment = $_POST['comment'];

$con = mysqli_connect("mysql11.000webhost.com","a9308444_bhaumik","5248ebdh","a9308444_first");
$sql = "INSERT INTO comment VALUES('$comment')";
$result = mysqli_query($con, $sql);
?>
<?php
header("Location: profile.html");
mysqli_close($con);
ob_flush();
?>