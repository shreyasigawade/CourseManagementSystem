
function ButtonMessage(){

    const displayMessage1 = () => {
        console.log("Message printed by clicking Click Me 1");
    }

    const displayMessage2 = (msg) => {
        console.log("Message printed by clicking Click Me 2:" + msg);
    }

    const displayMessage3 = (e) => {
        console.log(e);
        e.target.textContent = "Clicked";
    }
    return (
        <>
        <h2>Button Message Component</h2>
        {/* do not call the function in onClick event, only passs the function definition */}
        <button type='button' onClick={displayMessage1}>Click Me 1</button>
        <button type='button' onClick={()=>{displayMessage2("hello")}}>Click Me 2</button>
        <button type='button' onClick={(event)=>{displayMessage3(event)}}>Click Me 3</button>
        </>
    );
}
export default ButtonMessage;
