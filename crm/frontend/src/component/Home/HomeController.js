import React, { Component } from 'react'
import {  Link } from 'react-router-dom';

export class HomeController extends Component {
    constructor(props)
    {
        super(props);
        this.state = {
            message :''
        }
    }
    render() {
        return (
            <div class="container">
            <div class="row">
              <div class="col-sm-4">
               <h3>home controller message 

               {this.state.message} 
                   </h3> 
             
              <Link to={'/ui/contactus'} className="nav-link">Contact us</Link>
            </div>
            </div>
            </div>
        )
    }
    componentDidMount()
    {
        fetch('/api/home').then(response => response.json())
        .then(json => {
            this.setState({message:json.response});
        })
        
    }
}

export default HomeController
