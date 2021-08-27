import instance from './index';
//与后台保持一致的url前置
const preUrlPath = '/AlipayAward';
//获取列表
const list = {
    p: ['get,/roles'],
    r: params => {
        return instance.get(`${preUrlPath}/picture?` + params)
    }
};
const getAll = {
    p: ['get,/menu/list'],
    r: params=> {
        return instance.get(`${preUrlPath}/picture/all`)
    }
};
const remove = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.delete(`${preUrlPath}/picture/${params}`)
    }
};
const clock = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.put(`${preUrlPath}/picture/${params}`)
    }
}
const click = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.put(`${preUrlPath}/click/${params}`)
    }
}
const view = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.get(`${preUrlPath}/picture/${params}`)
    }
};
const edit = {
    p: ['get,/roles'],
    r: params => {
        return instance.put(`${preUrlPath}/picture`, params)
    }
};
const add = {
    p: ['get,/roles'],
    r: params => {
        return instance.post(`${preUrlPath}/picture`, params)
    }
};
const excelFileF = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.get(`${preUrlPath}/couponDown/${params}`)
    }
};
export {
    list,
    remove,
    view,
    edit,
    add,
    excelFileF,
    clock,
    click,
    getAll

}
