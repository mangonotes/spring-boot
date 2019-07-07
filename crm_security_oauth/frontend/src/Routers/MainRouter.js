import React from 'react'
import { Switch, Route } from 'react-router-dom'
import HomeController from '../component/Home/';
import ContactusController from '../component/Contactus/';

export default function MainRouter() {
    return (
        <div>
         <Switch>
        <Route exact path='/' component={HomeController}/>
        <Route path='/ui/contactus' component={ContactusController}/>
       
      </Switch>   
        </div>
    )
}
