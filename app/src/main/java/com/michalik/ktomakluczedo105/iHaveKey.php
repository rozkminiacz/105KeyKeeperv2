<?php


//catch arguments
if ($_GET) {
    $KeyKeeper = $_GET['keykeeper'];

} else {
    $KeyKeeper = $argv[1];
}
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO Key105 (User)
VALUES ('$KeyKeeper')";

if ($conn->query($sql) === TRUE) {
    echo "".$KeyKeeper." added";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

?>