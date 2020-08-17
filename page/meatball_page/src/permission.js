import router from './router'

router.beforeEach(async (to, from, next) => {
    if (to.path === ('/')) {
      next();
    } else {
      let user = localStorage.getItem('token');
      if (!user) {
        next({path: '/'})
      } else {
        next()
      }
    }
  }
);
