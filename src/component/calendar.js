import { Calendar, Alert } from 'antd';
import moment from 'moment';
import React from'react';
export default class MyCalendar extends React.Component{
    state={
        value:moment('2018-11-20'),
        selectedValue:moment('2018-11-20')
    }
    onSelect = (value) => {
        this.setState({
          value,
          selectedValue: value,
        });
      }
    onPanelChange=(value)=>{
        this.setState({value});
    }
    render() {
        const { value, selectedValue } = this.state;
        return (
          <div>
            <Alert message={`You selected date: ${selectedValue && selectedValue.format('YYYY-MM-DD')}`} />
            <Calendar value={value} onSelect={this.onSelect} onPanelChange={this.onPanelChange} />
          </div>
        );
      }
}