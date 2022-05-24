package com.example.cafe

class ResponseModel (
    val message : String,
    val status : Boolean

        )
    /*
    // 01. di MyApi.php
            val diatas harus sama dengan ini
            $Msg = json_encode(array("message" => "Blank Field !!", "status" =>false ));
			header ('Content-Type: application/json');
			echo $Msg;

	// 02 di postman
    {
    "message": "Add Menu",
    "status": true
    }
     */

