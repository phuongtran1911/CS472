<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Choose</title>
    </head>
    <body>
        <form method='post' action='ChooseServlet'>
            <p>Is JSP cool?</p>
            <input type='radio' value='1' name='radioJSPCool' ${state.yesCheck1}><span>Yes</span><br/>
            <input type='radio' value='0' name='radioJSPCool' ${state.noCheck1}><span>No</span><br/>
            <input type='submit' name='btnSubmit1' value='Submit'/>
            <p>Is JSF way cool?</p>
            <input type='radio' value='1' name='JSFwayCool' ${state.yesCheck2}><span>Yes</span><br/>
            <input type='radio' value='0' name='JSFwayCool' ${state.noCheck2}><span>No</span><br/>
            <input type='submit' name='btnSubmit2' value='Submit'/>
            <p>Is the moon made of cheese?</p>
            <input type='radio' value='1' name='moonCheese' ${state.yesCheck3}><span>Yes</span><br/>
            <input type='radio' value='0' name='moonCheese' ${state.noCheck3}><span>No</span><br/>
            <input type='submit' name='btnSubmit3' value='Submit'/>
        </form>
    </body>
</html>
