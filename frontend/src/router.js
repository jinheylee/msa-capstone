
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ScheduleManager from "./components/listers/ScheduleCards"

import ReviewManager from "./components/listers/ReviewCards"


import ScheduleView from "./components/ScheduleView"
import MessageManager from "./components/listers/MessageCards"

import CommunicationManager from "./components/listers/CommunicationCards"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/schedules',
                name: 'ScheduleManager',
                component: ScheduleManager
            },

            {
                path: '/reviews',
                name: 'ReviewManager',
                component: ReviewManager
            },


            {
                path: '/scheduleViews',
                name: 'ScheduleView',
                component: ScheduleView
            },
            {
                path: '/messages',
                name: 'MessageManager',
                component: MessageManager
            },

            {
                path: '/communications',
                name: 'CommunicationManager',
                component: CommunicationManager
            },



    ]
})
