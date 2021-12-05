# LearnJavaPrograming
This is a folder what have a few projects. When I start to learn Java program

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create table</title>
</head>
<body>
    <h1>STUDENT SURVEY</h1><br>
    <p>Please enter following servey to help us making better courses</p>
    <table style="border: thin solid black">
        <tr>
            <th align="left">Full name:</th>
            <th align="left"><input type="text" name="fullname"></th>
            <th align="left">Please write any comment:</th>
        </tr>
        <tr>
            <th align="left">Sex:</th>
            <th align="left"><input type="radio" name="gender" value="Male">Male <input type="radio" name="gender" value="Female"> Female</th>
            <th rowspan="13" align="left"><textarea name="textarea" cols="50" rows="20" style="border:1px solid blue">No more than 500 characters long</textarea></th>
        </tr>
        <tr>
            <th align="left">Upload your picture</th>
            <th align="left"><input type="file" name="upload_file" value="No file choose"></th>
        </tr>
        <tr>
            <th align="left">When do you want to start the course?</th>
            <th align="left"><input type="datetime" name="datetime_course"></th>
        </tr>
        <tr>
            <th align="left">What time do you want to start lecture?</th>
            <th align="left"><input type="time" name="time_lecture"></th>
        </tr>
        <tr>
            <th align="left">How many student(maximum) in the class?</th>
            <th align="left"><input type="number" name="number_student"></th>
        </tr>
        <tr>
            <th align="left">How good the program was?</th>
            <th align="left"><input type="range" name="range_slider"></th>
        </tr>
        <tr>
            <th align="left">Please select your favourite courses</th>
            <th align="left">
                <select name="box" size="6" multiple>
                    <optgroup label="Term1">
                        <option>C Programming</option>
                        <option>C++ Programming</option>
                        <option>Database</option>
                    </optgroup>
                    <optgroup label="Term2">
                        <option>Computer Architechture</option>
                    </optgroup>
                </select>
            </th>
        </tr>
        <tr>
            <th align="left"><button>Send</button><button>Clear</button></th>
        </tr>
        
    </table>
    
</body>
</html>
