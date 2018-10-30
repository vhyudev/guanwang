Page({

  /**
   * 页面的初始数据
   */
  // data: {
    
  // },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("1111");
    var adressArray = [
      {
        detailedAddress:'我在哪',
        recievePerson:"我是谁",
        phoneNum:'123443',
        isChecked:1,
        zoningCode :'54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321'

      },
      {
        detailedAddress: '我在哪',
        recievePerson: "我是谁",
        phoneNum: '123443',
        isChecked: 1,
        zoningCode: '54321',
        addressId:'2309'

      }
    ];
    this.setData({
      adressArray:adressArray,
      scrollTop:0
    });

  },
  edit:function(e){//编辑地址
    var addressId = e.currentTarget.id;
    console.log(addressId);
    wx.navigateTo({
      //url: '../goodsDetail/goodsDetail?goodsId=' + e.currentTarget.id,
      url: "../editAdress/editAdress?type='edit'&addressId=" + addressId,
    });
  },
  addAddress:function(e){
    wx.navigateTo({
      //url: '../goodsDetail/goodsDetail?goodsId=' + e.currentTarget.id,
      url: "../editAdress/editAdress?type='edit'",
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  }
})