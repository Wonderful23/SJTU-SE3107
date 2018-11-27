import React from 'react'
import {Table, Icon} from 'antd'

export default class myTable extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            tDate: [],
            selectedRowKeys: []
        }
    }

    componentDidMount() {
        const data = []
        data.push({
            key:1,
            name:"参考资料1",
            age:1,
            address:'React的教程',
            remark:'http://www.runoob.com/react/react-tutorial.html',
            operate:'运用于整个程序'
            
        })
        data.push({
            key:2,
            name:"参考资料2",
            age:2,
            address:'Highchart的教程',
            remark:'https://www.hcharts.cn/demo/highcharts',
            operate:'暂无'
            
        })
        data.push({
            key:3,
            name:"参考资料3",
            age:3,
            address:'Antd的教程',
            remark:'https://ant.design/docs/react/use-in-typescript-cn',
            operate:'暂无'
            
        })
        data.push({
            key:4,
            name:"参考资料4",
            age:4,
            address:'参考blog',
            remark:'https://www.cnblogs.com/luozhihao/p/5579786.html',
            operate:'暂无'
            
        })
        data.push({
            key:5,
            name:"参考资料5",
            age:5,
            address:'参考blog',
            remark:'https://blog.csdn.net/u013558749/article/details/68068519',
            operate:'暂无'
            
        })
        data.push({
            key:6,
            name:"参考资料6",
            age:6,
            address:'参考blog',
            remark:'http://web.jobbole.com/91580/',
            operate:'暂无'
            
        })


        this.setState({
            tDate: data
        })
    }

    // checkbox状态
    onSelectChange = (selectedRowKeys) => {
        console.log('selectedRowKeys changed: ', selectedRowKeys)
        this.setState({ selectedRowKeys })
    }

    render() {
        const columns = [{
            title: '序号',
            width: '20%',
            dataIndex: 'age'
        }, {
            title: '资料',
            width: '20%',
            dataIndex: 'name',
        }, {
            title: '描述',
            width: '20%',
            dataIndex: 'address'
        }, {
            title: '链接',
            width: '20%',
            dataIndex: 'remark',
            render(text) {
                return <a href={text} target="_blank">查看资料</a>
            }
        }, {
            title: '其他',
            width: '20%',
            dataIndex: 'operate'
        }]

        const { selectedRowKeys } = this.state

        const rowSelection = {
            selectedRowKeys,
            onChange: this.onSelectChange
        }

        const pagination = {
            total: this.state.tDate.length,
            showSizeChanger: true,
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize)
            },
            onChange(current) {
                console.log('Current: ', current)
            }
        }

        return (
            <Table rowSelection={rowSelection} columns={columns} dataSource={this.state.tDate} bordered pagination={pagination} />
        )
    }
}