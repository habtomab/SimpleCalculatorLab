<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="SimpleCalculator">
    <input type="text" name="txtnum1" pattern="\d+(\.\d{1,2})?" step="0.01"
           title="This should be a number with up to 2 decimal places."/>+ <input type="text" name="txtnum2"/>=<input
        type="text" name="txtSum"/><br/>

    <input type="text" name="txtnum3" value=""> * <input type="text" name="txtnum4"/>=<input type="text" name="txtMul"/><br/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>