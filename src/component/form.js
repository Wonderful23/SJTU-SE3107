import React from 'react'
import { Upload,Icon,Form, Input, Select, Checkbox, DatePicker, Col, Radio, Button, Modal, message } from 'antd'

const FormItem = Form.Item
const Option = Select.Option
const RadioGroup = Radio.Group

const prop = {
    name: 'file',
    action: '//jsonplaceholder.typicode.com/posts/',
    headers: {
      authorization: 'authorization-text',
    },
    onChange(info) {
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === 'done') {
        message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === 'error') {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
  };
class MyForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            visible: false
        }
    }

    // 选择select
    handleSelectChange = (value) => {
        console.log(`selected ${value}`)
    }

    // 提交表单
    handleSubmit = (e) => {
        e.preventDefault()
        console.log('收到表单值：', this.props.form.getFieldsValue())

        this.props.form.resetFields()
    }


    // 显示弹框
    showModal = () => {
        this.setState({ visible: true })
    }


    // 隐藏弹框
    hideModal = () => {
        this.setState({ visible: false })
    }

    render() {
        const { getFieldProps } = this.props.form

        const formItemLayout = {
            labelCol: { span: 3 },
            wrapperCol: { span: 6 }
        }

        const success = function () {
            message.success('操作成功!');
        }

        return (
            <Form horizontal onSubmit={this.handleSubmit}>

                <FormItem
                    label="日期选择框"
                    labelCol={{ span: 3 }}
                    required>
                    <Col span="2">
                        <FormItem>
                            <DatePicker {...getFieldProps('startDate')} />
                        </FormItem>
                    </Col>
                    <Col span="1">
                        <p className="ant-form-split">-</p>
                    </Col>
                    <Col span="2">
                        <FormItem>
                            <DatePicker {...getFieldProps('endDate')} />
                        </FormItem>
                    </Col>
                </FormItem>

                
                <FormItem
                    id="select"
                    label="项目种类"
                    {...formItemLayout}>
                    <Select id="select" size="large" defaultValue="C++" style={{ width: 200 }} onChange={this.handleSelectChange}
                        {...getFieldProps('contents')}>
                        <Option value="C++">C++</Option>
                        <Option value="JS">JS</Option>
                        <Option value="python" >python</Option>
                        <Option value="others" disabled>others</Option>
                    </Select>
                </FormItem>

                <FormItem
                    id="control-textarea"
                    label="项目简述"
                    {...formItemLayout}>
                    <Input type="textarea" id="control-textarea" rows="3" width="100%" hight="200%"
                    {...getFieldProps('content')} />
                </FormItem>
                
                <FormItem  id="control-upload"
                label="上传文件"
                {...formItemLayout}>>
                <Upload {...prop}>
                <Button>
                  <Icon type="upload" /> Click to Upload
                </Button>
                 </Upload>
                 </FormItem>

                <FormItem
                    id="control-input"
                    label="打分"
                    {...formItemLayout}
                    required>
                    <Input id="control-input" placeholder="Please enter..."
                    {...getFieldProps('userName')} />
                </FormItem>

                <FormItem wrapperCol={{ span: 6, offset: 3 }} style={{ marginTop: 24 }}>
                    <Button type="primary" htmlType="submit" onClick={success}>确定</Button>
                    &nbsp;&nbsp;&nbsp;
                </FormItem>
                <Modal title="登录" visible={this.state.visible} onOk={this.hideModal} onCancel={this.hideModal}>
                    这是一个modal
                </Modal>
            </Form>
        )
    }
}

MyForm = Form.create()(MyForm)

export default MyForm





