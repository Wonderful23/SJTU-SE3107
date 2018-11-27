import React from "react"
import img from"./face.png"
export default class Animate extends React.Component{
    render(){
        return(
            <view>
              <img src={img}  width="100" className="animated fadeInUp lastPic" /> 
            </view>
        );
    }
}