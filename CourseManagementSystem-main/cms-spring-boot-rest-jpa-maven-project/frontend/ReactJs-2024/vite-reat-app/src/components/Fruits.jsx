
import styles from './Fruits.module.css';

function Fruits(){
    let allFruits = ["pineapple", "orange", "grapes", "apple"];
// ul, li - unorder list
// <ul>
//      <li>pineapple</li>
//      <li>orange</li>
//      <li>grapes</li>
//</ul>

    let allFruitsDisplay = allFruits.map((eachFruit,index)=><li className={styles.items} key={index}>{eachFruit}</li>)
    return(
        <>
        <hr></hr>
        <h2 className={styles.head2}>List of Fruits</h2>
        <ul>
            {allFruitsDisplay}
        </ul>
        </>
    );
}

export default Fruits;
