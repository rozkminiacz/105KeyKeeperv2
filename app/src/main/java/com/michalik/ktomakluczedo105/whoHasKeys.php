<?php


//catch arguments
if ($_GET) {
    $last = $_GET['last'];
} else {
    $last = $argv[1];
}


$connection = mysqli_connect($servername, $username,$password,$dbname) or die("Error " . mysqli_error($connection));

    //fetch table rows from mysql db
    $sql = "SELECT TOP ".$last." FROM Key105 ORDER BY Date DESC";
    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    echo json_encode($emparray);

    //close the db connection
    mysqli_close($connection);

?>
