# class Solution:
#     def dividePlayers(self, skill: List[int]) -> int:
#         total_sum = 0
#         for i in skill:
#             total_sum += i
        
#         n = len(skill)
#         sumPossible = total_sum // (n// 2)
        
#         if total_sum % (n // 2) != 0:
#             return -1
        
#         skill.sort()
#         ans = 0
#         map = {}
        
#         for i in range(n // 2):
#             complement = sumPossible - skill[i]
            
#             if complement in skill[i+1:]:
#                 map[skill[i]] = complement
#                 skill.remove(complement)
#                 ans += skill[i] * complement
#             else:
#                 return -1
        
#         return ans



# way 2

class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        total_sum = sum(skill)
        n = len(skill)
        
        if total_sum % (n // 2) != 0:
            return -1
        
        sumPossible = total_sum // (n // 2)
        skill.sort()
        ans=0;
        for i in range(n // 2):
            if skill[i] + skill[n - 1 - i] != sumPossible:
                return -1
            ans += skill[i] * skill[n - 1 - i]
        return ans
