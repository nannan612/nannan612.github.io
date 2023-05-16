import request from '@/utils/request'

// 查询记事本列表
export function listTodolist() {
  return request({
    url: '/system/todolist/list',
    method: 'get',
  })
}

// 查询记事本详细
export function getTodolist(id) {
  return request({
    url: '/system/todolist/' + id,
    method: 'get'
  })
}

// 新增记事本
export function addTodolist(data) {
  return request({
    url: '/system/todolist',
    method: 'post',
    data: data
  })
}

// 修改记事本
export function updateTodolist(data) {
  return request({
    url: '/system/todolist',
    method: 'put',
    data: data
  })
}

// 删除记事本
export function delTodolist(id) {
  return request({
    url: '/system/todolist/' + id,
    method: 'delete'
  })
}
