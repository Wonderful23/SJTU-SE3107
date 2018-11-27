import React from 'react'
import ReactDOM from'react-dom'
import {Router,Route,Link,hashHistory,IndexRoute,Redirect,IndexLink} from'react-router'
import{Menu,Icon,Switch}from 'antd'
import MyTable from'./component/table'
import MyForm from'./component/form'
import MyCalendar from'./component/calendar'
import MyChart from'./component/chart'
import Animate from'./component/animate'
const SubMenu =Menu.SubMenu
const ACTIVE={color:'red'}
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
                  <img src='./component/face.png' width="50" id="logo" />
                  <Menu theme="dark" onClick={this.handleClick} style={{width:185}}
                  defaultOpenKeys={['sub1','sub2']}
                  defaultSelectedKeys={[this.state.current]}
                  mode='inline'>
                  <SubMenu key='sub1' title={<span><Icon type='mail'/><span> 导航一</span></span>}>
                    <Menu.Item key='1'> <Link to='/MyForm'>Form</Link></Menu.Item>
                    <Menu.Item key='2'> <Link to='/MyTable'>Table</Link></Menu.Item>
                    <Menu.Item key='3'> <Link to='/MyCalendar'>Calendar</Link></Menu.Item></SubMenu>
                    <SubMenu key='sub2' title={<span><Icon type='appstore'/><span> 导航二</span></span>}>
                    <Menu.Item key='4'> <Link to='/MyChart'>Chart</Link></Menu.Item>
                    <Menu.Item key='5'> <Link to='/Animate'>picture</Link></Menu.Item>
                    </SubMenu>
                    </Menu>
                    </div>
              <div id='rightwrap'><Menu mode='horizontal'>
                <SubMenu title={<span><Icon type='user'/>{this.state.username}</span>}>
                  <Menu.Item key='setting:1'>退出</Menu.Item>
                </SubMenu>
                </Menu>
            <div className='right-box'>
            {this.props.children}</div>
            </div>
</div>
        )
    }
}
ReactDOM.render((
    <Router history={hashHistory} >
        <Route path="/" component={Slider}>
            <IndexRoute path="myTable" component={MyTable} />
            <Route path="myForm" component={MyForm} />
            <Route path="myChart" component={MyChart} />
            <Route path="myCalendar" component={MyCalendar} />
            <Route path="myAnimate" component={Animate} />
            <Route path="myTable" component={MyTable} />
        </Route>
    </Router>
),
document.getElementById('example'));