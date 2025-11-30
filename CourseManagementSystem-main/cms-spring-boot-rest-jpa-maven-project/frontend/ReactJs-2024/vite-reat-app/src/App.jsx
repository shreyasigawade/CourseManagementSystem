import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HelloWorld from './HelloWorld'
import Display from "./components/Display";
import ButtonMessage from "./components/ButtonMessage";
import Fruits from './components/Fruits';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      { /*<HelloWorld/>*/}
      <Display/>  
      {/*<ButtonMessage/>*/}
      <Fruits/>
    </>
  )
}

export default App
