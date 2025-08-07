## #######################
## Delimited Continuations
## #######################

def follow_user(user, user_to_follow)
  if user_to_follow.blocked?(user)
    puts "#{user_to_follow.name} has blocked #{user.name}"
    return # early return
  end
  user.following << user_to_follow
  user_to_follow.followers << user
end
