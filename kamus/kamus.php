<?php
$host = 'localhost';
$user = 'root';
$pass = '';
$db = 'db_kamus';

$conn = new mysqli($host, $user, $pass, $db);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$request_method = $_SERVER['REQUEST_METHOD'];

switch ($request_method) {
    case 'GET':
        get_kamus($conn);
        break;
}

function get_kamus($conn)
{
    $result = $conn->query("SELECT * FROM kamus");
    $kamus = $result->fetch_all(MYSQLI_ASSOC);
    echo json_encode(array("result" => $kamus));
}
