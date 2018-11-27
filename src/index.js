import React from 'react'
import ReactDOM from'react-dom'
import {Router,Route} from'react-router'
import {Link,HashRouter} from'react-router-dom'
import{Menu,Icon,Switch}from 'antd'
import MyTable from'./component/table'
import MyForm from'./component/form'
import MyCalendar from'./component/calendar'
import MyChart from'./component/chart'
import Animate from'./component/animate'
import img from'./component/face.png'
import'./App.css'
const SubMenu =Menu.SubMenu
const ACTIVE={color:'red'}
class Slider1 extends React.Component{
    constructor(props){
        super(props)
        this.state={
            current:'',
            username:''
        }
    }
    handleClick=(e)=>{
        this.setState({
            current:e.key
        })
    }
    componentDidMount(){
        this.getUser()
    }
    getUser=()=>{
        this.setState({
            username:'用户1'
        })
    }
    render(){
        return(
            <div>
            <div id='right-box'>
                    <MyForm /></div>
              <div id='leftMenu'>
              <h2 id='Tt'>React</h2>
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
                    
            </div>
        )
    }
}

class Slider2 extends React.Component{
    constructor(props){
        super(props)
        this.state={
            current:'',
            username:''
        }
    }
    handleClick=(e)=>{
        this.setState({
            current:e.key
        })
    }
    componentDidMount(){
        this.getUser()
    }
    getUser=()=>{
        this.setState({
            username:'用户1'
        })
    }
    render(){
        return(
            <div>
            <div id='right-box'>
                    <Animate /></div>
              <div id='leftMenu'>
              <h2 id='Tt'>React</h2>
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
                    
            </div>
        )
    }
}

class Slider3 extends React.Component{
    constructor(props){
        super(props)
        this.state={
            current:'',
            username:''
        }
    }
    handleClick=(e)=>{
        this.setState({
            current:e.key
        })
    }
    componentDidMount(){
        this.getUser()
    }
    getUser=()=>{
        this.setState({
            username:'用户1'
        })
    }
    render(){
        return(
            <div>
            <div id='right-box'>
                    <MyChart /></div>
              <div id='leftMenu'>
              <h2 id='Tt'>React</h2>
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
                    
            </div>
        )
    }
}

class Slider4 extends React.Component{
    constructor(props){
        super(props)
        this.state={
            current:'',
            username:''
        }
    }
    handleClick=(e)=>{
        this.setState({
            current:e.key
        })
    }
    componentDidMount(){
        this.getUser()
    }
    getUser=()=>{
        this.setState({
            username:'用户1'
        })
    }
    render(){
        return(
            <div>
            <div id='right-box'>
            <MyTable/></div>
              <div id='leftMenu'>
              <h2 id='Tt'>React</h2>
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
                   
            </div>
        )
    }
}

class Slider5 extends React.Component{
    constructor(props){
        super(props)
        this.state={
            current:'',
            username:''
        }
    }
    handleClick=(e)=>{
        this.setState({
            current:e.key
        })
    }
    componentDidMount(){
        this.getUser()
    }
    getUser=()=>{
        this.setState({
            username:'用户1'
        })
    }
    render(){
        return(
            <div>
            <div id='right-box'>
            <MyCalendar /></div>
              <div id='leftMenu'>
              <h2 id='Tt'>React</h2>
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
                   
            </div>
        )
    }
}

class Slider extends React.Component{
    constructor(props){
        super(props)
        this.state={
            current:'',
            username:''
        }
    }
    handleClick=(e)=>{
        this.setState({
            current:e.key
        })
    }
    componentDidMount(){
        this.getUser()
    }
    getUser=()=>{
        this.setState({
            username:'用户1'
        })
    }
    render(){
        return(
            <div>
              <div id='leftMenu'>
              <h2 id='Tt'>React</h2>
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
            </div>
        )
    }
}
ReactDOM.render((
    <HashRouter>
    <div>
        <Route path="/" component={Slider}/>
            <Route path="/MyTable" component={Slider4} />
            <Route path="/MyForm" component={Slider1} />
            <Route path="/MyChart" component={Slider3} />
            <Route path="/MyCalendar" component={Slider5} />
            <Route path="/Animate" component={Slider2} />
        </div>
    </HashRouter>
),
document.getElementById('example'));