package come.zbx.handsometrend.fragment;

import androidx.fragment.app.Fragment;

/**
 * 分享-多选好友界面
 */
public class ShareFriendFragment extends Fragment {

//    @Bind(R.id.launch_chat_side_bar)
//    public SideBar sideBar;
//    @Bind(R.id.launch_chat_list)
//    public ListView listView;
//
//    private View view;
//    //是否可见
//    public boolean isVisible = false;
//    //是否初始化完成
//    public boolean isInit = false;
//    //是否已经加载过
//    public boolean isLoadOver = false;
//
//    private List<UIUserInfo> friendUserList;
//    private LaunchChatMemberAdapter memberAdapter;
//    private FragmentCallbackListener callbackListener;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        if (view == null) {
//            view = View.inflate(getActivity(), R.layout.launch_chat_friend, null);
//            ButterKnife.bind(this, view);
//            isInit = true;
//            setParams();
//        }
//        return view;
//    }
//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        this.isVisible = isVisibleToUser;
//        setParams();
//    }
//
//    private void setParams() {
//        if (isInit && !isLoadOver && isVisible) {
//            isLoadOver = true;
//            doInit();
//        }
//    }
//
//    private void doInit() {
//        friendUserList = new ArrayList<>();
//        memberAdapter = new LaunchChatMemberAdapter(getActivity(), friendUserList);
//        listView.setAdapter(memberAdapter);
//        sideBar.setOnStrSelectCallBack((index, selectStr) -> {
//            for (int i = 0; i < friendUserList.size(); i++) {
//                if (selectStr.equalsIgnoreCase(friendUserList.get(i).getCategory())) {
//                    listView.setSelection(i); // 选择到首字母出现的位置
//                    return;
//                }
//            }
//        });
//        listView.setOnItemClickListener((adapterView, view, position, l) -> {
//            UIUserInfo friendEntrty = friendUserList.get(position);
//            int select_postion = 0;
//            String type = "";
//            if (friendEntrty.isChecked()) {
//                friendEntrty.setChecked(false);
//                for (int i = 0; i < ShareActivity.selectedUserList.size(); i++) {
//                    if ((ShareActivity.selectedUserList.get(i).getUserInfo().uid).equals(friendEntrty.getUserInfo().uid)) {
//                        select_postion = i;
//                        type = "remove";
//                        break;
//                    }
//                }
//            } else {
//                friendEntrty.setChecked(true);
//                if (ShareActivity.selectedUserList.size() > 0) {
//                    for (UIUserInfo entrty : ShareActivity.selectedUserList) {
//                        if (!(entrty.getUserInfo().uid).equals(friendEntrty.getUserInfo().uid)) {
//                            select_postion = ShareActivity.selectedUserList.size();
//                            type = "add";
//                            ShareActivity.selectedUserList.add(friendEntrty);
//                            break;
//                        }
//                    }
//                } else {
//                    select_postion = ShareActivity.selectedUserList.size();
//                    type = "add";
//                    ShareActivity.selectedUserList.add(friendEntrty);
//                }
//            }
//            if (null != callbackListener) {
//                callbackListener.callback(select_postion, type);
//            }
//            memberAdapter.notifyDataSetChanged();
//        });
//        listView.setDivider(null);
//        synchronizeUsersInfo();
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        callbackListener = (FragmentCallbackListener) context;
//    }
//
//    private void synchronizeUsersInfo() {
//        List<UserInfo> listUserInfo = ChatManager.Instance().getMyFriendListInfo(true);
//        for(UserInfo userInfo : listUserInfo){
//            userInfo.selectType = 0;
//        }
//        friendUserList = ConvertEntityUtils.userInfoListToUIUserInfoList(listUserInfo);
//        memberAdapter.notifyChange(friendUserList);
//    }

}