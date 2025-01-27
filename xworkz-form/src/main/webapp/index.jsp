<html>
<head>
        <meta charset="UTF-8">
        <title>Xworkz</title>
        <style>
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f2f2f2;
                }

                form {
                    width: 60%;
                    margin: 40px auto;
                    padding: 20px;
                    background-color: #fff;
                    border: 1px solid #ddd;
                    border-radius: 10px;
                    box-shadow: 0 0 10px rgba(0,0,0,0.1);
                }

                h1 {
                    text-align: center;
                }

                label {
                    display: block;
                    margin-bottom: 10px;
                }

                input[type="text"] {
                    width: 100%;
                    height: 40px;
                    margin-bottom: 20px;
                    padding: 10px;
                    border: 1px solid #ccc;
                    border-radius: 5px;
                }

                input[type="submit"] {
                    width: 100%;
                    height: 40px;
                    background-color: #4CAF50;
                    color: #fff;
                    padding: 10px;
                    border: none;
                    border-radius: 5px;

                }

                input[type="submit"]:hover {
                    background-color: #3e8e41;
                }
        </style>
</head>
<body>
<form action="register" method="post">
        <h1>Registration Form</h1>
        <label>Enter Full Name:</label>
        <input type="text" name="name"><br>
        <label>Enter Contact Number:</label>
        <input type="text" name="contactNo"><br>
        <label>Enter WhatsApp Number:</label>
        <input type="text" name="email"><br>
        <label>Enter USN:</label>
        <input type="text" name="usn"><br>
        <label>Enter Qualification:</label>
        <input type="text" name="qualification"><br>
        <label>Passout:</label>
                <input type="text" name="passout"><br>


        <input type="submit" value="Register" name="register" >
</form>
</body>
</html>