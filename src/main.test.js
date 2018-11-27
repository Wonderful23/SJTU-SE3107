import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Animate from'./component/animate'
import MyForm from'./component/form'
import MyTable from'./component/table'
import MyChart from './component/chart'
import MyCalendar from'./component/calendar'
it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<App />, div);
  ReactDOM.unmountComponentAtNode(div);
});
it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<Animate />, div);
  ReactDOM.unmountComponentAtNode(div);
});
it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<MyForm />, div);
  ReactDOM.unmountComponentAtNode(div);
});
it('renders without crashing', () => {
    const div = document.createElement('div');
    ReactDOM.render(<MyTable />, div);
    ReactDOM.unmountComponentAtNode(div);
  });
  it('renders without crashing', () => {
    const div = document.createElement('div');
    ReactDOM.render(<MyCalendar />, div);
    ReactDOM.unmountComponentAtNode(div);
  });