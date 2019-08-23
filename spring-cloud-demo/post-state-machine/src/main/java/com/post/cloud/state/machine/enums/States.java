package com.post.cloud.state.machine.enums;public enum States {
    // 状态：待审核
    STATE_WAIT_AUDIT,
    // 状态：审核驳回
    STATE_AUDIT_REJECT,
    // 状态：待发送
    STATE_WAIT_SEND,
    // 状态：已上报运营商
    STATE_SEND_COMPLETE,
    // 状态：已删除
    STATE_DELETE_COMPLETE
}
