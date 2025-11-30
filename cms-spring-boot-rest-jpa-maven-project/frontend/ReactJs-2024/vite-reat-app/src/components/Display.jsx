
import { Fragment } from "react";
// we have to create a component here
// create in 2 ways
    //1. class based components 
            // - fading out but not removed completely
            // - here class is used to create the component
    //2. function based components - very frequently used
            // - functions are commonly used to create the component for its simplicity
function Display(){
    const hero1 = 'Iron Man';
    const hero2 = 'The incredible Hulk';
    // here we can make the function return jsx
    return(
        <>

        {/* <Fragment> */}
        {/* <div> */}
            <h2>Display Component</h2>
            <h3>Super Man</h3>
            <h3>{hero1}</h3>
            <h3>{hero2.toUpperCase()}</h3>
            <hr></hr>
        {/* </div> */}
         {/* </Fragment> */}
        </>
        
    );
}
export default Display;
